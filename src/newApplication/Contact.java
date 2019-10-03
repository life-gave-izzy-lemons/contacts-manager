package newApplication;

public class Contact {
    private String name;
    private String number;

    public Contact(String name, String number) {
        this.name = name;
        setNumber(number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        String newNum = "";
        if(number.length() == 7){
           newNum = number.replaceFirst("(\\d{3})(\\d+)", "$1-$2");
        }else if(number.length() == 10){
            newNum =  number.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
        }
        this.number = newNum;

    }
}
