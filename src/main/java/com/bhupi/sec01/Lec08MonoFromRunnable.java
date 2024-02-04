package com.bhupi.sec01;

import com.bhupi.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {

    public static void main(String[] args) {

        Mono.fromRunnable(timeConsumingProcess())
            .subscribe(Util.onNext(),
                    Util.onError(),
                    () -> {
                        System.out.println("Process is done. Sending email notification...!!!");
                    }
            );
    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Operation completed");
        };
    }
}
