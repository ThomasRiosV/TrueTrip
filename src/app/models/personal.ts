import { User } from "./user";

export class Personal {
    id: number;
    firstName: string;
    lastName: string;
    email: string;
    dateOfBirth: Date;
    address: string;
    city: string;
    state: string;
    country: string;
    phoneNumber: string;
    //user: User
  
    constructor(
      id: number,
      firstName: string,
      lastName: string,
      email: string,
      dateOfBirth: Date,
      address: string,
      city: string,
      state: string,
      country: string,
      phoneNumber: string,
      //user: User
    ) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.dateOfBirth = dateOfBirth;
      this.address = address;
      this.city = city;
      this.state = state;
      this.country = country;
      this.phoneNumber = phoneNumber;
      //this.user = user;
    }
  }
