package com.my.qihualu.java8;

import com.my.qihualu.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author luqihua
 * @title: StreamTest
 * @projectName qihualu
 * @description: TODO
 * @date 2019/8/7
 */
public class StreamTest {

    public static void main(String[] args) {
        new StreamTest().testGroupBy();
    }

    private void testGroupBy() {
        List<User> userList = this.getUserList();
        Map<Integer, List<String>> collect = userList.stream().collect(Collectors.groupingBy(User::getAge, Collectors.mapping(User::getName, Collectors.toList())));
        collect.forEach((k,v)-> System.out.println(v));
    }

    private List<User> getUserList() {
        List<User> list = new ArrayList<>();
        list.add(new User("01", "李明", 28));
        list.add(new User("02", "孙明", 26));
        list.add(new User("03", "陈明", 25));
        list.add(new User("04", "小明", 28));
        list.add(new User("05", "大明", 25));
        list.add(new User("06", "明明", 26));
        list.add(new User("07", "无明", 25));
        list.add(new User("08", "凯明", 27));
        list.add(new User("09", "猴明", 28));
        return list;
    }
}
