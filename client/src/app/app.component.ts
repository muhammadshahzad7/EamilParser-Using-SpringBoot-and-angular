import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ResponseData, ValidationService } from './services/validation.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule,],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'emails app';

  constructor(private validationService:ValidationService){}
  invalidEmails: string[] = [];
  input = new FormControl("", [Validators.required])
  
  public existingEmails= [
    {
      "firstname": "Ali",
      "lastname": "Ahmad",
      "email": "ali@gmail.com"
    }
  ]

  emailForm = new FormGroup({
    input: this.input
  })

  sendData(){
    this.validationService.sendData(this.emailForm.value.input!).subscribe((response: ResponseData) => {
      console.log("Response: ", response);
      this.invalidEmails = response.invalidEmails;
      console.log("Invalid Emails: ", this.invalidEmails);
    });
      
  }

  ngOnInit(){
    this.getExistingEmails();
  }

  getExistingEmails(){
    this.validationService.getExistingEmails().subscribe((data:any) => {
      this.existingEmails = data;
      console.log("existing emails: ", this.existingEmails);
    })
  }

  validate(){
    this.sendData();
    this.getExistingEmails();
  }
  getInvalidEmails() {
    return this.invalidEmails.filter(email => email.startsWith('Invalid Email'));
  }
}
