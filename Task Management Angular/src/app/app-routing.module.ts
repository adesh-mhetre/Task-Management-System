import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterUserComponent } from './component/register-user/register-user.component';
import { LoginUserComponent } from './component/login-user/login-user.component';
import { GetTasksComponent } from './component/get-tasks/get-tasks.component';
import { UpdateTaskComponent } from './component/update-task/update-task.component';

const routes: Routes = [
  {path: "", component: LoginUserComponent},
  {path: "register", component: RegisterUserComponent},
  {path: "tasks", component: GetTasksComponent},
  {path: "updatetask/:userId/:id", component: UpdateTaskComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
