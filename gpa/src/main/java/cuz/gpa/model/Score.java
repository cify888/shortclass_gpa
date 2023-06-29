package cuz.gpa.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Score {
    private String sid;
    private String cid;
    private Double score;

    public String getCid(){
        return cid;
    }
    public String getSid(){
        return sid;
    }
    public double getScore(){
        return score;
    }
}
