import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
// export class AuthService {
//   private loggedInUserId: number | null = null;

//   constructor() {}

//   setLoggedInUserId(userId: number): void {
//     this.loggedInUserId = userId;
//   }

//   getLoggedInUserId(): number | null {
//     return this.loggedInUserId;
//   }

//   logout(): void {
//     // Clear the stored user ID on logout
//     this.loggedInUserId = null;
//     // You might want to add additional logout logic here
//   }
// }


export class AuthService {
  private loggedInUserIdKey = 'loggedInUserId';

  constructor() {}

  setLoggedInUserId(userId: number): void {
    localStorage.setItem(this.loggedInUserIdKey, String(userId));
  }

  getLoggedInUserId(): number | null {
    const userId = localStorage.getItem(this.loggedInUserIdKey);
    return userId ? +userId : null;
  }

  logout(): void {
    localStorage.removeItem(this.loggedInUserIdKey);
  }
}