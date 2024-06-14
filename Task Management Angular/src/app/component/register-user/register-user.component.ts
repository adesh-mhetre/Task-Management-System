import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AbstractControl, ValidationErrors } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {
  registerUserForm!: FormGroup;
  registerSuccess: boolean = false;

  constructor(private userService: UserService,
              private fb: FormBuilder, 
              private router: Router) { }

  ngOnInit() {
    this.registerUserForm = this.fb.group({
      name: [null, Validators.required],
      email: [null, [Validators.required, Validators.email]],
      userName: [null, [Validators.required, Validators.pattern('^[a-z0-9_]+$')]],
      password: [null, Validators.required],
    });
  }
  lowercaseValidator(control: AbstractControl): ValidationErrors | null {
    const value = control.value;
    if (value && value !== value.toLowerCase()) {
      return { lowercase: true };
    }
    return null;
  }

  registerUser() {
    if (this.registerUserForm.valid) {
      this.userService.registerUser(this.registerUserForm.value).subscribe((res) => {
        if (res == null) {
          alert("Username Already Exists");
        } else {
          this.registerSuccess = true;
        }
      });
    }
  }
}
