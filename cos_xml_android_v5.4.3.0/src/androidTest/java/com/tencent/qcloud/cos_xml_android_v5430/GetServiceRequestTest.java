package com.tencent.qcloud.cos_xml_android_v5430;


import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.service.GetServiceRequest;
import com.tencent.cos.xml.model.service.GetServiceResult;

import org.junit.Test;


/**
 * Created by bradyxiao on 2017/12/4.
 */
public class GetServiceRequestTest extends ApplicationTestCase {

    static final String TAG = "Unit_Test";

    GetServiceRequest getServiceRequest = new GetServiceRequest();

    public GetServiceRequestTest() {
        super(Application.class);
    }


    public void getMethod() throws Exception {
        assertEquals("GET", getServiceRequest.getMethod());
    }


    public void getHostPrefix() throws Exception {
        assertEquals("service", getServiceRequest.getHostPrefix());
    }


    public void getPath() throws Exception {
        assertEquals("/", getServiceRequest.getPath());
    }


    public void getRequestBody() throws Exception {
        assertEquals(null, getServiceRequest.getRequestBody());
    }


    public void checkParameters() throws Exception {
    }


    public void init(){
        QService.init(getContext());
    }

    @Test
    public void testGetService() throws CosXmlServiceException, CosXmlClientException {
        init();
        GetServiceResult getServiceResult = QService.cosXmlClient.getService(getServiceRequest);
        Log.d(TAG, getServiceResult.printResult());
    }

    @Test
    public void testGetService2() throws CosXmlServiceException, CosXmlClientException {
        init();
        QService.cosXmlClient.getServiceAsync(getServiceRequest, new CosXmlResultListener() {
            @Override
            public void onSuccess(CosXmlRequest request, CosXmlResult result) {
                Log.d(TAG, result.printResult());
            }

            @Override
            public void onFail(CosXmlRequest request, CosXmlClientException exception, CosXmlServiceException serviceException) {
                Log.d(TAG, exception == null ? serviceException.getMessage() : exception.toString());
            }
        });

    }

}