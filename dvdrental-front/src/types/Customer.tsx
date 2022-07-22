export class Customer {
    customerId: number;
    storeId: number;
    firstName: string;
    lastName: string;
    email: string;
    addressId: number;
    activebool: boolean;
    createDate:Date;
    lastUpdate:Date;
    active:number;
    
    constructor(customerId: number, storeId: number, firstName: string, lastName: string, email: string, addressId: number, 
        activebool: boolean, createDate: Date, lastUpdate:Date, declineText:string, active:number){
        this.customerId = customerId;
        this.storeId = storeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.addressId = addressId;
        this.activebool = activebool;
        this.createDate =createDate;
        this.lastUpdate = lastUpdate;
        this.active = active;

    }
}