import { Component } from '@angular/core';
import { TaskService } from '../../service/task.service';
import { AuthService } from '../../service/auth.service';

@Component({
  selector: 'app-get-tasks',
  templateUrl: './get-tasks.component.html',
  styleUrl: './get-tasks.component.css'
})
export class GetTasksComponent {
  tasks: any = []
  userId: any =this.authService.getLoggedInUserId();

  constructor(private service: TaskService,
    private authService:AuthService){}

  ngOnInit(){
    this.getAllTasks();
  }

  getAllTasks()
  {
    this.service.getTasks(this.userId).subscribe((res)=>{
        console.log(res);
        this.tasks = res;
    });
  }

  deleteTask(taskId:number){
    console.log(taskId);
    this.service.deleteTask(taskId,this.userId).subscribe((res)=> {
      console.log(res);
      this.getAllTasks();
    })
  }
}
