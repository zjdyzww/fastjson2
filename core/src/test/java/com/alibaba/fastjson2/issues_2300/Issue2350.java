package com.alibaba.fastjson2.issues_2300;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.annotation.JSONField;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Issue2350 {
    @Test
    public void test() {
        String json = "{\n" +
                "\t\"testField\": \"My Test\",\n" +
                "\t\"testField2\": \"My Test2\"\n" +
                "}";
        Bean bean = JSON.parseObject(json, Bean.class);
        assertEquals("My Test", bean.testField);
        assertNull(bean.getTestField2());

        String str = JSON.toJSONString(bean);
        System.out.println(str);
    }

    public static class Bean {
        @JSONField(deserializeFeatures = JSONReader.Feature.FieldBased, serializeFeatures = JSONWriter.Feature.FieldBased)
        private String testField;
        private String testField2;

        public String getTestField2() {
            return testField2;
        }
    }
}
