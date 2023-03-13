package GeneratingGenerations;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class DataPot {
    static private DataPot instance;
    private LocationData locations;
    private FNameData femaleNames;
    private MNameData maleNames;
    private SNameData surNames;

    static public DataPot getInstance(){
        if(instance == null){
            instance = new DataPot();
        }
        return instance;
    }

    private DataPot() {
        Gson gson = new Gson();
        try{
            String dir = "src/main/java/GeneratingGenerations/json/";
            Reader reader = new FileReader(dir+"locations.txt");
            this.locations = gson.fromJson(reader, LocationData.class);
            reader.close();
            reader = new FileReader(dir+"fnames.txt");
            this.femaleNames = gson.fromJson(reader,FNameData.class);
            reader.close();
            reader = new FileReader(dir+"mnames.txt");
            this.maleNames = gson.fromJson(reader, MNameData.class);
            reader.close();
            reader = new FileReader(dir+"snames.txt");
            this.surNames = gson.fromJson(reader,SNameData.class);
            reader.close();

        }catch(IOException ex){
            ex.printStackTrace();
            System.out.println("Issue reading files.");
        }
    }


    public LocationData getLocations() {
        return locations;
    }


    public FNameData getFemaleNames() {
        return femaleNames;
    }


    public MNameData getMaleNames() {
        return maleNames;
    }


    public SNameData getSurNames() {
        return surNames;
    }

}
