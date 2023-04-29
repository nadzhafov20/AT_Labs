package lab_5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTask {
    public static void main(String[] args) {








        //part1:
        List<User> userList = generateUserList(10);
        System.out.println(userList);
        //part2:
        System.out.println(userList.stream().sorted().collect(Collectors.toList()));
        //part3:
        System.out.println(userList.stream().sorted((o1, o2) -> o1.getAge().compareTo(o2.getAge()) * o1.getName().compareTo(o2.getName())).collect(Collectors.toList()));
        System.out.println(userList.stream().filter(u-> {return u.getAge() > 5;}).collect(Collectors.toList()));

        //part4:
        userList.stream().map(u->u.getName()).collect(Collectors.toList());
    }

    private static List<User> generateUserList(int n) {
        Random random = new Random();
        List<User> userList=new ArrayList<>();
        IntStream.range(1, n).forEach(i -> {
            User user = new User();
            user.setName("userName" + UUID.randomUUID().toString().substring(0,6));
            user.setAge(random.nextInt(100));
            userList.add(user);

        });
        return userList;
    }
}
