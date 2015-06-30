package com.company;

import jp.ac.it_college.std.nakasone.lib.exam.Communicator;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Communicator comm = new Communicator((msg) -> {
            System.out.println(msg);
        });

        comm.start();
        String name = "s14008:";

        while (true) {
            Scanner stdIn = new Scanner(System.in);
            System.out.println("メッセージを入力してください");
            String nao = stdIn.next();
            if (nao.equals("exit")) {
                try {
                    comm.send(name + "切断しました");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                comm.finish();
                break;;
            } else {
                try {
                    comm.send(name + nao);
                } catch (IOException var3) {
                    var3.printStackTrace();
                }
            }
        }
    }
}