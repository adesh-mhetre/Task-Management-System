import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../../service/user.service';
import { AuthService } from '../../service/auth.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login-customer',
  templateUrl: './login-user.component.html',
  styleUrl: './login-user.component.css'
})
export class LoginUserComponent {

  loginCustomerForm!: FormGroup;

  constructor(private userService : UserService,
    private fb:FormBuilder,private router:Router, 
    private authService : AuthService){}

  ngOnInit(){
    this.loginCustomerForm=this.fb.group({
      userName:[null,Validators.required],
      password:[null,Validators.required]
    })

  }

  loginUser() {
    console.log(this.loginCustomerForm.value);
    this.userService.loginUser(this.loginCustomerForm.value).subscribe((res) => {
      console.log(res); // Log the entire response for debugging
      if (res && res.status) {
        // Successful login
        alert('Login successful');
        // You can redirect to another page if needed
        this.authService.setLoggedInUserId(res.userId);

        this.router.navigate(['/tasks']);
      } else {
        // Failed login
        alert('Login failed: ' + res.message);
      }
    },
      (error) => {
        console.error(error); // Log the error for debugging
        alert('An error occurred during login');
      });
  }

  


}
