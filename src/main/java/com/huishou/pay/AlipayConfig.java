package com.huishou.pay;

public class AlipayConfig {
	// 商户appid
	public static String APPID = "2018083161167993";
	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDpOyYVhjlBefSV\n" +
			"FJwgiI/eNqoyuSIvIQ2ZJDR4igtEX+1IoN5hmkMOpN8ViosBJz+sqtLcX9JvIVQQ\n" +
			"PFahUso3nvwtwlvIM+KFN0gWFqTcWpgy+UuRB6yMgzgjJtxcGAjpoxjyXYiistB4\n" +
			"TAKycA7+4yzvkPru6L0V3JUsYIhYxzefALPTz8EX1e1CpveHuuX4w+QbpKCiBAlE\n" +
			"UY+106f2WM5lhCD8/JEELRDYfrGOiqWiH4RLygUtudxIAb6cpwv1Xn9jkl3c60X1\n" +
			"W1m8W9/Vmt1rZCfmAZOMhzcCe8hjooCkIo8GgsdJB9aARZogKX3Xh7swI5Hro3HY\n" +
			"s1mM2gWxAgMBAAECggEAU684dAKsKpUysAcsGfRGAsqEeRy6akSm12sJNLL7ZfYx\n" +
			"cpzeDhFGvEtmDBmg1LIbg73rWM08+UjxG746qznEev6dp2GUgxoyze/O+rX3Q2Vy\n" +
			"NOAEQC6LuAMhMmOwL48kK4is29G5w/77FB7Z3OKeTtB+gBr6Hpz9s4lpMPoWEhwB\n" +
			"sCuIlVSP0vaZHbpbWvceynV4U9oREpATh5W7LKaAlvs679E2oUKhRHRrmNmsu07j\n" +
			"ZdXFT18tAVAYP1tir8S4PiWcDmRfpfup2hElfs6bZNyAf25h74prMzLx4J3e8b3j\n" +
			"iemmBFL2PU+LXiLdwN711kmc5o+rQz2jJUSN3qfAjQKBgQD6FXDhDhZOjU69vj9y\n" +
			"G0CQoSxul7NsretrX9nm9BEEOB77MQhT+qySH9BjAE6BhUeThCf0sUbIc7PxlQTp\n" +
			"ADHkEnVaMZovTzqgLam07MN7eWcswF4wy60nq8ki6rityyplixmMKCxKKxYlJiBy\n" +
			"IorLs/wKHwsa5tnFQaH/XWoorwKBgQDuv6T1AGQdtNyZ/wQJtEJme3ttnnrHUckD\n" +
			"L4n+tr8cFwT+L2BJC+wuUwdFyWl9HS2HfT7NPgk3ICZdJVLLihDNaKIeU2A/P+8d\n" +
			"+MgsTpC8jEdQmtYMjOh41lKHPCiz+2i1hDZgcJFbkno0R1dgq2gq70NTcIWbDfdi\n" +
			"Emf3Eh+PnwKBgCsodBiCw9q+jC42nOBmT5gmGHLlfzNsOEqJeiNfT2h4/u++oH9N\n" +
			"rWZyUxYiwWmcxKNylSqnRV3midFRNE25mOKRROtR0BgGBkoKV1U/3uR6KRISCK9H\n" +
			"FxTXkpiSBVkIzMJFZR1I+Yu7L9EtaUAJMgbBgueEP/heiop+LyTQzDdFAoGBALuM\n" +
			"6y3X983qVV3YGjjxVTQijsyHMZZApjMNdk8VCj4ryy1O1EmtxwSBDvaAiZDSigCk\n" +
			"n+AleqHGbLzBZDAmrppeNvSxtKsbM2GNHNrJgSPM4vzsFXhYfQrn+n7oAGWa+x+U\n" +
			"1A6gf1+7Sqqk3HxBSpxnxrDWdO5gY1S0dt19bDOrAoGBAKqblhtK38qusU3SxzJn\n" +
			"XM1IP8qEocwQGJrDMr8Ur6CoXk3nsiXoyBGQIilNbYhyLBKPYsVfu4AUghwSHhRY\n" +
			"rvHjCT8W6goYBFMrEP/VmDdkSmcxpsD+uOb7FAyyhPVd872Qi9HkKU2NCSU8JJ5P\n" +
			"NDrnKbdiNcRv+ehF7suU4CBS";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://2131t012t5.51mypc.cn:19518/pay/notifyPay";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	public static String return_url = "http://2131t012t5.51mypc.cn:19518/pay/returnPay";
	// 请求网关地址
	public static String URL = "https://openapi.alipay.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhjE4fCxv6qkOXQDn7j+YrZpjAy2XaWpwzpD5DcNVueNk8iGBOUqa/TjVYrC5svjK33l1LTV6hWrlnHR2yCu+p/DAxSZTNKeThJXefU4RQM7umr9/H4vr4aSlXmgF40vefXs71wzn1MYUKIBN/fYyALcx5Ubh8v/FOXn9ljGuKH9gPcxm727HJZZnOgnS3FNGPz4yKRzYZeqaxA5x4glwCOqEmitePY51nw+myK/Pf5Aeq449oahCCMhYlaVnakYeXOmMVSE2Qp6OK4fXipWJ83VOYCk06934nFyvZtF3OyEjhg2GExwM0ECpLpe3QMeAduJXlgDYOQsKP9zrxq9jxQIDAQAB";
	// 日志记录目录
	public static String log_path = "/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";
}
