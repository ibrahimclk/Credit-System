package com.paycore.CreditSystem.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class ScoreService {

    public int getScore(String identityno){
        int score = 0;
        switch (Integer.parseInt((String.valueOf(identityno.charAt(identityno.length() - 1))))){
            case 0:
            case 1:
                score = 550;
                break;
            case 2:
            case 3:
                score = 1200;
                break;
            case 4:
            case 5:
                score = 300;
                break;
            case 6:
            case 7:
                score = 800;
                break;
            case 8:
            case 9:
                score = 1600;
                break;

        }
        return score;
    }

}
