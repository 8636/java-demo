package com.example.alipaydemo;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.response.AlipayTradeCreateResponse;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CreateService {
    private static final Logger   logger = LoggerFactory.getLogger(CreateService.class);
    public Object alipayTradeCreateService(){
	AlipayTradeCreateRequest alipayRequest = new AlipayTradeCreateRequest();
	//请确认是否在工程中引入了fastjson
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("out_trade_no", "业务参数");
	params.put("seller_id", "业务参数");
	params.put("total_amount", "业务参数");
	params.put("discountable_amount", "业务参数");
	params.put("undiscountable_amount", "业务参数");
	params.put("buyer_logon_id", "业务参数");
	params.put("subject", "业务参数");
	params.put("body", "业务参数");
	params.put("buyer_id", "业务参数");
	params.put("goods_detail", "业务参数");
	params.put("product_code", "业务参数");
	params.put("operator_id", "业务参数");
	params.put("enable_pay_channels", "业务参数");
	params.put("store_id", "业务参数");
	params.put("disable_pay_channels", "业务参数");
	params.put("terminal_id", "业务参数");
	params.put("extend_params", "业务参数");
	params.put("timeout_express", "业务参数");
	params.put("royalty_info", "业务参数");
	params.put("settle_info", "业务参数");
	params.put("alipay_store_id", "业务参数");
	params.put("sub_merchant", "业务参数");
	params.put("merchant_order_no", "业务参数");
	params.put("logistics_detail", "业务参数");
	params.put("ext_user_info", "业务参数");
	params.put("business_params", "业务参数");
	params.put("receiver_address_info", "业务参数");
	//设置业务参数，bizContent为发送的请求信息，开发者需要根据实际情况填充此类
	Object obj = JSONObject.toJSON(params);
	alipayRequest.setBizContent(obj.toString());
	//sdk请求客户端，已将配置信息初始化
    AlipayClient alipayClient = getAlipayClient();
	AlipayTradeCreateResponse alipayResponse = null;
	try {
		//因为是接口服务，使用exexcute方法获取到返回值
		alipayResponse = alipayClient.execute(alipayRequest);
		if(alipayResponse.isSuccess()){
			logger.info("调用成功");
			//TODO 实际业务处理，开发者编写。可以通过alipayResponse.getXXX的形式获取到返回值
		} else {
			logger.info("调用失败");
		}
		return alipayResponse;				
		} catch (AlipayApiException e) {
		    if(e.getCause() instanceof java.security.spec.InvalidKeySpecException){
		        return "商户私钥格式不正确，请确认配置文件alipay_openapi_sanbox.properties中是否配置正确";
		    }
		}
		return alipayResponse;				
    }
    public static AlipayClient getAlipayClient() {
    		ResourceBundle bundle = ResourceBundle.getBundle("alipay_openapi_sanbox");
    		// 网关
    		String URL = bundle.getString("ALIPAY_GATEWAY_URL");
    		// 商户APP_ID
    		String APP_ID = bundle.getString("APP_ID");
    		// 商户RSA 私钥
    		String APP_PRIVATE_KEY = bundle.getString("RSA2_PRIVATE_KEY");
    		// 请求方式 json
    		String FORMAT = bundle.getString("FORMAT");
    		// 编码格式，目前只支持UTF-8
    		String CHARSET = bundle.getString("CHARSET");
    		// 支付宝公钥
    		String ALIPAY_PUBLIC_KEY = bundle.getString("ALIPAY_RSA2_PUBLIC_KEY");
    		// 签名方式
    		String SIGN_TYPE = bundle.getString("SIGN_TYPE");
    		return new DefaultAlipayClient(URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
    	}}