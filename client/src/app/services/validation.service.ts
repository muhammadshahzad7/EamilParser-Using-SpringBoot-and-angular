// import { HttpClient, HttpResponse } from '@angular/common/http';
// import { Injectable } from '@angular/core';

// export interface ResponseData {
//   validEmails: Array<{ firstname: string, lastname: string, email: string }>;
//   invalidEmails: string[];
// }

// @Injectable({
//   providedIn: 'root'
// })


// export class ValidationService {
//   constructor(private http:HttpClient){}

//   // public array of strings
//   invalidEmails: string[] = [];
//   existingEmails: string[] = [];
  
//   sendData(input:string){
//     console.log("Data: ", input);

//     const url = 'http://localhost:8080/api/mail';

//     return this.http.post<ResponseData>(url, {data: input},{
//       headers: {
//         'Content-Type': 'application/json',
//         'Access-Control-Allow-Origin': '*',
//         'Access-Control-Allow-Methods': 'POST',
//       }
//     })
    
//   }

//   getExistingEmails(){
//     const url = 'http://localhost:8080/api/mail';

//     return this.http.get<string[]>(url, {
//       headers: {
//         'Content-Type': 'application/json',
//         'Access-Control-Allow-Origin': '*',
//         'Access-Control-Allow-Methods': 'GET',
//       }
//     })
//   }
// }
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

export interface EmailData {
  data: string;
}

export interface Email {
  firstName: string;
  lastName: string;
  email: string;
}

export interface ResponseData {
  validEmails: Email[];
  invalidEmails: string[];
}

@Injectable({
  providedIn: 'root'
})
export class ValidationService {

  private apiUrl = 'http://localhost:8080/api/mail';

  constructor(private http: HttpClient) { }

  sendData(input: string) {
    console.log("Data: ", input);

    const requestData: EmailData = { data: input };

    return this.http.post<ResponseData>(this.apiUrl, requestData);
  }

  getExistingEmails() {
    return this.http.get<string[]>(this.apiUrl);
  }
}

