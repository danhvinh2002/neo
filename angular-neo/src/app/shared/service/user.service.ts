import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class UserService {
  readonly API = 'http://localhost:8080'

  constructor(private http: HttpClient) {

}
  getAll() : Observable<any> {
  return this.http.get(`${this.API}/api/user/getAll`);
}
  addUser(user: any) : Observable<any> {
    return this.http.post(`${this.API}/api/user/add`, user);
  }
  updateUser(user: any) : Observable<any> {
    return this.http.put(`${this.API}/api/user/update`, user);
  }
  deleteUser(id: any) : Observable<any> {
    return this.http.delete(`${this.API}/api/user/delete/${id}`);
  }
  getById(id: any) : Observable<any> {
    return this.http.get(`${this.API}/api/user/get/${id}`);
  }
  getByName(searchName: any) : Observable<any> {
    return this.http.get(`${this.API}/api/user/findByName/${searchName}`);
  }
  getSortName() : Observable<any> {
    return this.http.get(`${this.API}/api/user/sortByName`);
  }
  getProvince() : Observable<any> {
    return this.http.get(`http://localhost:8080/api/province/all`);
  }
  getDistrict() : Observable<any> {
    return this.http.get(`http://localhost:8080/api/district/all`);
  }
  getWard() : Observable<any> {
    return this.http.get(`http://localhost:8080/api/wards/all`);
  }
  getDistrictsByProvinceId(id: any) : Observable<any> {
    return this.http.get(`http://localhost:8080/api/district/getProvince/${id}`);
  }
  getWardsByDistrictId(id: any) : Observable<any> {
    return this.http.get(`http://localhost:8080/api/wards/getByDistrictId/${id}`);
  }
}
