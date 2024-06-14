import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TaskService } from '../../service/task.service';
import { AuthService } from '../../service/auth.service';

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrl: './add-task.component.css'
})
export class AddTaskComponent {
  addTaskForm!: FormGroup;

  constructor(private taskService : TaskService,
    private fb:FormBuilder,private router:Router,
    private authService:AuthService ){}

  ngOnInit(){
    this.addTaskForm = this.fb.group({
      name:[null,Validators.required],
      status:[null,[Validators.required]],
      importance:[null,Validators.required],
    })
    
  }

  addTask() {
    if (this.addTaskForm.valid) {
      const newTask = this.addTaskForm.value;
      this.taskService.addTask(newTask,this.authService.getLoggedInUserId()).subscribe({
        next: (res) => {
          console.log('Task added successfully:', res);
          this.addTaskForm.reset();
          const currentUrl = this.router.url;
          this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
            this.router.navigate([currentUrl]);
          });
        },
        error: (error) => {
          console.error('Error adding task:', error);
        }
    });
    } else {
      this.addTaskForm.markAllAsTouched();
    }
  }
 
}
