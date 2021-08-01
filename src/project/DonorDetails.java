package project;

public class DonorDetails {
    public String Name, Age, BloodType, City, Phone;

    public DonorDetails( String[] Data ){
        this.Name = Data[0];
        this.Age = Data[1];
        this.BloodType = Data[2];
        this.City = Data[3];
        this.Phone = Data[4];
    }
}
