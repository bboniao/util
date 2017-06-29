package com.bboniao.util.example.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by guhb on 27/06/2017.
 */
public class JacksonDemo {

    /**
     * Jackson提供了一系列注解，方便对JSON序列化和反序列化进行控制，下面介绍一些常用的注解。
        @JsonIgnore 此注解用于属性上，作用是进行JSON操作时忽略该属性。
        @JsonFormat 此注解用于属性上，作用是把Date类型直接转化为想要的格式，如@JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")。
        @JsonProperty 此注解用于属性上，作用是把该属性的名称序列化为另外一个名称，如把trueName属性序列化为name，@JsonProperty("name")。
        */

    public static void main(String[] args) throws ParseException, IOException {
        User user = new User();
        user.setName("小民");
        user.setEmail("xiaomin@sina.com");
        user.setAge(20);

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(dateformat.parse("1996-10-01"));

        /*
          ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
          ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
          writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
          writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
          writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
          writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
         */
        ObjectMapper mapper = new ObjectMapper();

        //让jackson支持jaxb注解的配置
//        mapper.registerModule(new JaxbAnnotationModule());

        //为null的属性值不映射
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);//@JsonInclude(Include.NON_NULL)

        //排序
        mapper.enable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);

        //Map中value为null, 是否序列化
        mapper.disable(SerializationFeature.WRITE_NULL_MAP_VALUES);

        //有属性不能映射的时候不报错
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        //User类转JSON
        //输出结果：{"name":"小民","age":20,"birthday":844099200000,"email":"xiaomin@sina.com"}
        String json = mapper.writeValueAsString(user);
        System.out.println(json);

        //Java集合转JSON
        //输出结果：[{"name":"小民","age":20,"birthday":844099200000,"email":"xiaomin@sina.com"}]
        List<User> users = new ArrayList<User>();
        users.add(user);
        String jsonlist = mapper.writeValueAsString(users);
        System.out.println(jsonlist);


        json = "{\"name\":\"小民\",\"age\":20,\"birthday\":844099200000,\"email\":\"xiaomin@sina.com\"}";

        /**
         * ObjectMapper支持从byte[]、File、InputStream、字符串等数据的JSON反序列化。
         */
        mapper = new ObjectMapper();
        user = mapper.readValue(json, User.class);
        System.out.println(user);
    }
}
