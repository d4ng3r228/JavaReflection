package com.company;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {
        String myPath = "F:\\text.txt";
        Serializator serializator = new Serializator();
        Field[] fields = Class.forName("com.company.Serializator").getFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Save.class)) {
                    FileWriter writer= new FileWriter(myPath);
                    writer.write(field.getName() +"."+ field.get(serializator));
                    writer.flush();
                }
            }
            FileReader fileReader = new FileReader(myPath);
            BufferedReader reader = new BufferedReader(fileReader);
            var name = reader.readLine();
            while (name !=null){
                System.out.println(name);
                name= reader.readLine();
            }
//        Task task = new Task();
//        Annotation MyAnnotation = task.getClass().getAnnotation(MyAnn.class);
//
//        Method[] methods = Class.forName("com.company.Task").getMethods();
//        for (Method method : methods) {
//            if (method.isAnnotationPresent(MyAnn.class)) {
//                MyAnn myAnn = method.getAnnotation(MyAnn.class);
//                method.invoke(task, myAnn.a(), myAnn.b());
//            }
//        }
//        TextContainer textContainer = new TextContainer();
//        Field field = Class.forName("com.company.TextContainer").getField("text");
//
//        Method[] methods1 = Class.forName("com.company.TextContainer").getMethods();
//        if (textContainer.getClass().isAnnotationPresent(SaveTo.class)) {
//            SaveTo saveTo = textContainer.getClass().getAnnotation(SaveTo.class);
//            for (Method method : methods1) {
//                if (method.isAnnotationPresent(Saver.class)) {
//                    method.invoke(textContainer, saveTo.myPath(), field.get(textContainer));
//
//                }
//            }
//        }
//
//        Field[] fields2 = Class.forName("com.company.Serial").getFields();
//        for (Field field1 : fields2) {
//            if (field1.isAnnotationPresent(Save.class)) {
//                String s = field1.toString();
//                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("saved.txt"))) {
//                    oos.writeObject(s);
//                    System.out.println(s);
//                } catch (Exception exception) {
//                    System.out.println(exception.getMessage());
//                }
//                System.out.println(" ");
//                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("saved.txt"))) {
//                    ois.readObject();
//                    System.out.println(s);
//                }
//                catch (Exception exception) {
//                    System.out.println(exception.getMessage());
//                }
//            }
//        }
    }
}

