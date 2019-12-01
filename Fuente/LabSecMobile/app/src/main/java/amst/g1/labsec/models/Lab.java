package amst.g1.labsec.models;

public class Lab {

    private String id;
    private String name;
    private String description;
    private String location;
    private String inCharge;

    public Lab() { }

    public Lab(String id, String name, String description, String location, String inCharge) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.inCharge = inCharge ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInCharge() {
        return inCharge;
    }

    public void setInCharge(String inCharge) {
        this.inCharge = inCharge;
    }

    public boolean isValid() {
        boolean validName = name != null && !name.equals("");
        boolean validDesc = description != null && !description.equals("");
        boolean validLoc = location != null && !location.equals("");
        boolean validInCharge = inCharge != null && !inCharge.equals("");
        return validName && validDesc && validLoc && validInCharge;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", inCharge='" + inCharge + '\'' +
                '}';
    }
}
