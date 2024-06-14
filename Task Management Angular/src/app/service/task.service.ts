import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

const BASIC_URL = "http://localhost:8080/api";
@Injectable({
  providedIn: 'root'
})
export class TaskService {


  constructor(private http: HttpClient, private authService: AuthService) { }

  deleteTask(id: number, userId: any): Observable<any> {
    const url = BASIC_URL + "/deletetask/" + userId + "/" + id;
    return this.http.delete(url);
  }

  addTask(task: any, userId: any):Observable<any> {
    return this.http.post(BASIC_URL + "/tasks/" + userId, task);
  }


  getTasks(userId: any): Observable<any> {
    console.log(this.authService.getLoggedInUserId())
    // this.userid = this.authService.getLoggedInUserId();
    return this.http.get(BASIC_URL + "/gettasks/" + userId);
  }

  getTaskById(userId: any,taskId: number) {
    const url = BASIC_URL + "/gettasks/" + userId + "/" + taskId;
    return this.http.get(url);
  }

  updateTask(userId: any,id: number, task: any) {
    const url = BASIC_URL + "/updatetask/" + userId + "/" + id;
    return this.http.put(url,task);
  }

}
