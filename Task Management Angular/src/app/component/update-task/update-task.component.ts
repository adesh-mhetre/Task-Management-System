import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TaskService } from '../../service/task.service';
import { AuthService } from '../../service/auth.service';

@Component({
  selector: 'app-update-task',
  templateUrl: './update-task.component.html',
  styleUrl: './update-task.component.css'
})
export class UpdateTaskComponent {

  updateTaskForm!: FormGroup;
  userId :any = this.authService.getLoggedInUserId();
  id: number=this.activatedRoute.snapshot.params['id'];


  constructor(private activatedRoute: ActivatedRoute,
  private service: TaskService,
  private fb:FormBuilder,
  private router:Router,private authService : AuthService){}



  ngOnInit(){
    this.getTaskById();
    this.updateTaskForm = this.fb.group({
      name:[null,Validators.required],
      status:[null,Validators.required],
      importance:[null,Validators.required],
    })
    
  }

  getTaskById(){
    this.service.getTaskById(this.userId,this.id).subscribe((res)=>{
      console.log(res);
      this.updateTaskForm.patchValue(res);
    });
  }

  updateTask()
  {
    this.service.updateTask(this.userId,this.id,this.updateTaskForm.value).subscribe((res)=>{
      console.log(res);
      this.router.navigateByUrl("/tasks");
    });
  }
}
