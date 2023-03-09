package ExampleCode;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JSONexample {

    public static void run(File file){

        try(FileReader fileReader = new FileReader(file)){

        } catch (IOException ex){
            System.out.println("File not working! Message: " + ex);
        }



    }
}


/*
In JSON you can have an array, denoted by [], or an object, denoted by {}.
You can have arrays inside of objects or vice versa, to make an arbitrarily
complex object in JSON. JSON supports numbers, strings, booleans, and 'null'
This is an example of a JSON string:

{
    "CATALOG": [
        "CD": {
            "TITLE": Blah blah
            "ARTIST": ect
            "COUNTRY": Wherever
            "COMPANY": null
            "PRICE": 2.2222
            "YEAR": 1,213
        }
        "CD": {
            "TITLE":
            "ARTIST":
            "COUNTRY":
            "COMPANY":
            "PRICE":
            "YEAR":
        }
        "CD": {
            "TITLE":
            "ARTIST":
            "COUNTRY":
            "COMPANY":
            "PRICE":
            "YEAR":
        }
    ]
}
 */