class Customer
{
    private String name;
    private String address;
    private long phone;

    Customer(String name, String address, long phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public long getPhone()
    {
        return phone;
    }

    public String getAddress()
    {
        return address;
    }

    public String getName()
    {
        return name;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setPhone(long phone)
    {
        this.phone = phone;
    }

    public String toString()
    {
        return "Name: " + this.name + "\n" +
                "Address: " + this.address + "\n" +
                "Phone: " + this.phone;
    }
}
