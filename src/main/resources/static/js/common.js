;(function () {
    this.Util = {};

    /**
     * 字符串非空判断
     * @param str 字符串
     * @returns {boolean}
     */
    this.Util.isEmpty = function (str) {
        return str==null || str.length==0;
    }

    /**
     * 获取选项序号A、B、C、D...
     * @param index Order序号
     * @returns {boolean}
     */
    this.Util.getOrder = function (index) {
        var fullOrder = ['A','B','C','D'];
        index = index? index :0;
        return fullOrder[index];
    }
    /**
     * 更新答题界面右上序号 01/05
     * @param total 试题数目
     * @returns {boolean}
     */
    this.Util.updateRightOrder = function (total) {
        total = total < 10? '0'.concat(total) : total;
        $(".answer_order").html('<span class="green-span">01</span >/'+ total +'');
        $(".swiper-container").swiper({
            onTouchEnd:function () {
                setTimeout(function () {
                    var currentIndex = $(".swiper-slide-active").index() + 1;
                    currentIndex = currentIndex < 10? '0'.concat(currentIndex) : currentIndex;
                    $(".answer_order").html('<span class="green-span">'+ currentIndex +'</span >/'+ total +'');
                },100);
            }
        });
    }

    /**
     * 确认框
     * @param text 提示内容
     * @param callbackOk 确认回调函数
     */
    this.Util.comfirm = function (text,callbackOk) {
        if(callbackOk){
            $.alert(text, callbackOk)
        }else {
            $.alert(text)
        }
    }

    /**
     * 提示框
     * @param text 提示内容
     * @param callbackOk 确认回调函数
     */
    this.Util.alert = function (text,callbackOk) {
        $.toast(text);
    }
    this.Util.ajaxGet = function (url,data,callback) {
      $.ajax({
          url:url,
          data:data,
          type:'get',
          dataType:'json',
          success:function (data) {
              callback(data);
          },
      })
    }
    this.Util.ajaxPost = function (url,data,callback) {
        $.ajax({
            url:url,
            type:'post',
            dataType:'json',
            data:JSON.stringify(data),
            contentType: 'application/json',
            success:function (result) {
                callback(result);
            },
        })
    }
    this.Util.ajaxNormalPost = function (url,data,callback) {
        $.ajax({
            url:url,
            type:'post',
            data:data,
            dataType:'json',
            success:function (result) {
                callback(result);
            },
        })
    }

    this.Util.exportCollection = function (type) {
        var title = type==1? '我的收藏':'我的错题本';
        Util.ajaxGet('getCollection.do',{type:type},function (data) {
            if(!data || data.length == 0){
                Util.alert('暂无数据');
                return;
            }
            var docDefinition = {
                content: [
                    {
                        text: title,
                        style:'title'
                    },
                ],
                /*自定义样式*/
                styles: {
                    title:{
                        bold: true,
                        fontSize: 18,
                        italic: true,
                        alignment: 'center',
                    },
                    dry: {
                        bold: false,
                        fontSize: 15,
                        margin:[0,10]

                    },
                    option: {
                        bold: false,
                        fontSize: 15,

                    }
                },
                defaultStyle: {
                    font: '微软雅黑'
                }
            };
            $.each(data,function (index,question) {
                var option = {
                    'A':'A',
                    'B':'B',
                    'C':'C',
                    'D':'D',
                };
                docDefinition.content.push({text: index+1 +'.'+question.question, style:'dry'});
                docDefinition.content.push({text:question.option, style:'dry'});
                for(var order in option){
                    docDefinition.content.push({text: order + '.' + option[order], style:'option'});
                }
            });

            pdfMake.createPdf(docDefinition).download(title + '.pdf');
        });
    }

    this.Util.exportCollectionAnswer = function (type) {
        var title = type == 1? '我的收藏答案':'我的错题本答案';
        Util.ajaxGet('getCollection.do',{type:type},function (data) {
            if(!data || data.length == 0){
                Util.alert('暂无数据');
                return;
            }
            var docDefinition = {
                content: [
                    {
                        text: title,
                        style:'title'
                    },
                ],
                /*自定义样式*/
                styles: {
                    title:{
                        bold: true,
                        fontSize: 18,
                        italic: true,
                        alignment: 'center',
                    },
                    dry: {
                        bold: false,
                        fontSize: 15,
                        margin:[0,10]

                    },
                    option: {
                        bold: false,
                        fontSize: 15,

                    }
                },
                defaultStyle: {
                    font: '微软雅黑'
                }
            };
            $.each(data,function (index,question) {
                docDefinition.content.push({text: index+1 +'.'+question.question, style:'dry'});
                docDefinition.content.push({text:'【正确答案】'+question.answer, style:'dry'});
            });

            pdfMake.createPdf(docDefinition).download(title + '.pdf');
        });

    }
})();