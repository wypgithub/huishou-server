/**
 * Created by Administrator on 2018/7/1 0001.
 */
(function($){
    $.fn.RecordTime = function () {
        var timeStr = [];
        var $this =  this;
        var hh = 0;
        var mm = 0;
        var ss = 0;
        setInterval(function () {
            if(ss < 59){
                ss++;
            }else {
                if(mm < 59){
                    mm++;
                }else {
                    hh++;
                    mm = 0;
                }
                ss = 0;
            }
            //填充2位数字
            timeStr[0] = formatTime(hh);
            timeStr[1] = formatTime(mm);
            timeStr[2] = formatTime(ss);
            $this.text(timeStr.join(':'));
        },1000)

        function formatTime(value) {
            if(value>9){
                return value;
            }
            return'0'+ value;
        }
    }

    function Answer($canvas,param) {
        this.$canvas = $canvas;
        this.type = param.type;
        this.zsdId = param.zsdId;
        this.questions = param.questions;
    }
    Answer.prototype = {
        /**
         * 初始化试题界面
         * @param question 试题
         */
        initQuestions:function () {
            var answerTemplate =
                '<div class="swiper-slide" name="@ID">' +
    '               <div class="card-content-inner">@HEADER</div>'+
    '               <div class="list-block"><ul>@OPTION</ul></div>'+
    '               <div class="list-block error_analysis">' +
    '                   <div class="card-content-inner red-span">【试题答案】<span class="answer"></span></div>' +
    '                   <div class="card-content-inner green-span">【试题解析】<span class="analysis"></span></div>' +
    '               </div>'+
                '</div>';
            var optionTemplate = '<li>'+
                '<label class="label-checkbox item-content @ORDER">'+
                '<div class="item-media"><i class="icon icon-form-checkbox">@ORDER</i></div>'+
                '<div class="item-inner">'+
                '<div class="item-title">@CONTENT</div>'+
                '</div>'+
                '</label>'+
                '</li>';

            var answerHtml = '';
            $.each(this.questions,function (index,question) {
                //初始完成状态
                question.finish = false;

                var optionHtml = '';

                var option;
                if(this.type == 1){
                    question.question = question.question +'<br/>'+ question.option;
                    option = {
                        'A':'A',
                        'B':'B',
                        'C':'C',
                        'D':'D',
                    };
                }else {
                    option = JSON.parse(question.option);
                }
                for(var order in option){
                    optionHtml += optionTemplate.replace(/@ORDER/g,order).replace('@CONTENT',option[order]);
                }
                answerHtml += answerTemplate.replace('@ID',question.id)
                    .replace('@HEADER',question.question)
                    .replace('@OPTION',optionHtml);
            });
            this.$canvas.html(answerHtml);
        },
        bindHandel:function () {
            var _this = this;
            var questions = _this.questions;

            $('.label-checkbox').click(function () {
                //当前顶层窗口
                var $canvas = $(".swiper-slide-active");
                //当前试题
                var question = questions[parseInt($(".answer_order span").text())-1];
                if(question.finish){
                    return;
                }
                //选择的选项
                question.chooseAnswer = $(this).find('i').text();
                if(question.chooseAnswer == question.answer){
                    question.result = 'correct';

                    $(this).parent().find('.icon-form-checkbox').css({
                        'background-color':'green',
                        'color':'#fff'
                    });
                    $(this).parent().find('.item-inner').css({
                        'color':'green'
                    });
                }else {
                    question.result = 'wrong';

                    $(this).parent().find('.icon-form-checkbox').css({
                        'background-color':'red',
                        'color':'#fff'
                    });
                    $(this).parent().find('.item-inner').css({
                        'color':'red'
                    });
                    //提示正确答案
                    $canvas.find('.' + question.answer +' .icon-form-checkbox').css({
                        'background-color':'green',
                        'color':'#fff'
                    });
                    $canvas.find('.' + question.answer +' .item-inner').css({
                        'color':'green'
                    });
                    //显示试题解析
                    $canvas.find(".answer").text(question.answer);
                    $canvas.find(".analysis").text(question.analysis);
                    $canvas.find('.error_analysis').show();
                }

                //已经完成
                question.finish = true;
            });
            $(".add_error_btn").click(function () {
                var collection = {
                    stId:$(".swiper-slide-active").attr('name'),
                    type:2,
                };
                Util.ajaxPost('collection.do',collection,function (data) {
                    if(data==true){
                        Util.alert('添加成功');
                    }else {
                        Util.alert('本试题已加入错题本');
                    }
                });
            });
            $(".add_sc_btn").click(function () {
                var collection = {
                    stId:$(".swiper-slide-active").attr('name'),
                    type:1,
                };
                Util.ajaxPost('collection.do',collection,function (data) {
                    if(data==true){
                        Util.alert('添加成功');
                    }else {
                        Util.alert('本试题已加入收藏');
                    }
                });
            });
            $(".add_report_btn").click(function () {
                var finish = true;
                $.each(questions,function (index,question) {
                    if(question.finish == false){
                        finish = false;
                        return false;
                    }
                });
                if(finish == false){
                    Util.alert('请做完试题再查看');
                    return;
                }

                var record_time = $(".record_time").text();
                //存储参数
                localStorage.setItem('zsdId',_this.zsdId);
                localStorage.setItem('questions',JSON.stringify(questions));
                localStorage.setItem('time_consuming', record_time);

                //转换时间为秒
                record_time = record_time.split(':');
                var total = 0;
                if(record_time[0]){
                    total += parseInt(record_time[0]) * 60;
                }
                if(record_time[1]){
                    total += parseInt(record_time[1]);
                }
                if(record_time[2]){
                    total += parseFloat(record_time[2])/60;
                }
                //每题时间均分
                total = total/questions.length;
                //保存答题结果
                var answer = [];
                $.each(questions,function (index,question) {
                    answer.push({
                        answerTime:total.toFixed(2),
                        stId:question.id,
                        answer:question.chooseAnswer,
                        judgment: question.result == 'correct'? 1 : 0,
                        type:0,//题型:练习
                    });
                });
                Util.ajaxPost('answer.do',answer,function (data) {
                    if(data == true){
                        //跳转做题报告
                        location.href = 'report.do';
                    }
                });
            });
        }
    };

    $.fn.Answer = function (param) {
        var answer = new Answer(this,param);
        answer.initQuestions();
        answer.bindHandel();

        Util.updateRightOrder(param.questions.length);
    }

    $.extend({
        //导出错题本
        "exportWrongBookReport": function () {
            Util.exportCollection(2);
        },
        //导出错题答案
        "exportWrongAnswerReport": function () {
            Util.exportCollectionAnswer(2);
        },
        //导出收藏
        "exportCollectionReport": function () {
            Util.exportCollection(1);
        },
        //导出收藏答案
        "exportCollectionAnswerReport": function () {
            Util.exportCollectionAnswer(1);
        }
    });







    $(function () {
        //作业功能暂不开放
        $(".homework").click(function () {
            Util.alert('该模块建设中');
        });
    });
})(jQuery);