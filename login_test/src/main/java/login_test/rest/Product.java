package login_test.rest;

public class Product {
    private int id;
    private String question1;
    private String deathday;
    private String question3;
    private Boolean question4;
    private Boolean question5;
    private String text;


    public Product(){}

    public Product(int id, String deathday, String question1, String question3, Boolean question4, Boolean question5,
                   String text){
        this.id = id;
        this.deathday = deathday;
        this.question1=question1;
        this.question3=question3;
        this.question4=question4;
        this.question5=question5;
        this.text=text;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getQuestion3(){
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }
    public String getText(){
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public Boolean getQuestion5(){
        return question5;
    }

    public void setQuestion5(Boolean question5) {
        this.question5 = question5;
    }
    public String getQuestion1(){
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }
    public String getDeathday(){
        return deathday;
    }

    public void setDeathday(String deathday) {
        this.deathday = deathday;
    }

    public Boolean getQuestion4(){
        return question4;
    }

    public void setQuestion4(Boolean question4) {
        this.question4 = question4;
    }

}
