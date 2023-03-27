import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from 'src/app/shared/service/user.service';
import Swal from 'sweetalert2';
import {Province} from "../../shared/user/provinces/province";
import {District} from "../../shared/user/district/district";
import {User} from "../../shared/user/user/user";
import {Ward} from "../../shared/user/ward/ward";
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  p: number =1;
  formGroup!: FormGroup;
  user: any = new User();
  searchName: any;
  Provinces?: Province[];
  Districts?: District[];
  Wards?: Ward[];
  id?: any;
  checkButton!: boolean;
  sort!: boolean;
  basicSelectedOption :number = 5;
  constructor(private formBuilder: FormBuilder, private userService: UserService) { }

  ngOnInit(): void {
    this.checkButton = true;
    this.getAll();
    this.getProvince();
    this.getDistricts();
    this.getAllWards();
    this.formGroup = this.formBuilder.group({
      id: [''],
      name: ['',Validators.required],
      email: ['',[Validators.required, Validators.email]],
      age: ['',Validators.required],
      birthday: ['',Validators.required],
      address: ['',Validators.required],
      sex: [1],
      province: ['',Validators.required],
      district: ['',Validators.required],
      wards: ['',Validators.required],
    });
  }

  getAll() {
    this.userService.getAll().subscribe(data => {
      console.log("thành công", data);
      this.user = data;
    }, error => {
      console.log("lỗi", error);
    });
  }

  addUser() {
    this.userService.addUser(this.formGroup.value).subscribe(data => {
      console.log("thành công", data);
      this.getAll();
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Success',
        showConfirmButton: false,
        timer: 1500
      })
      this.clearForm();
    }, error => {
      console.log("lỗi", error);
    });
  }
  editUser(user: any) {
    this.checkButton = false;
    this.formGroup.patchValue(user);
    console.log(user.id);
  }
  updateUser() {
    this.userService.updateUser(this.formGroup.value).subscribe(data => {
      console.log("thành công", data);
      this.getAll();
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Success',
        showConfirmButton: false,
        timer: 1500
      })
      this.clearForm();
    }, error => {
      console.log("lỗi", error);
    });
  }
  clearForm() {
    this.checkButton = true;
    this.formGroup = this.formBuilder.group({
      id: [''],
      name: ['',Validators.required],
      email: ['',[Validators.required, Validators.email]],
      age: ['',Validators.required],
      birthday: ['',Validators.required],
      address: ['',Validators.required],
      sex: [1],
      province: ['',Validators.required],
      district: ['',Validators.required],
      wards: ['',Validators.required],
    });
  }
  deleteUser(id: any) {
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire(
          'Deleted!',
          'Your file has been deleted.',
          'success'
        )
        this.userService.deleteUser(id).subscribe(data => {
          console.log("thành công", data);
          this.getAll();
        });
      }
    })
  }
  getByName() {
    console.log(this.searchName);
    this.userService.getByName(this.searchName).subscribe(data => {
      console.log("thành công", this.searchName);
      this.user = data;
    }, error => {
      console.log("lỗi", error);
    });
  }
  checkSearch() {
    if (this.searchName == "") {
      this.getAll();
    } else {
      this.getByName();
    }
  }
  AddOrUpdate(){
    if(this.formGroup.invalid){
      this.formGroup.markAllAsTouched();
      return;
    }
    if(this.checkButton){
      this.addUser();
    }else{
      this.updateUser();
    }
  }
  sortName(){
    this.sort = !this.sort;
    if(this.sort){
      this.user.sort((a:any,b:any)=>a.name.localeCompare(b.name));
    }else{
      this.user.sort((a:any,b:any)=>b.name.localeCompare(a.name));
    }
  }
  sortId(){
    this.sort = !this.sort;
    if(this.sort){
      this.user.sort((a:any,b:any)=>a.id-b.id);
    }else{
      this.user.sort((a:any,b:any)=>b.id-a.id);
    }
  }
  sortAge(){
    this.sort = !this.sort;
    if(this.sort){
      this.user.sort((a:any,b:any)=>a.age-b.age);
    }else{
      this.user.sort((a:any,b:any)=>b.age-a.age);
    }
  }
  getProvince() {
    this.userService.getProvince().subscribe(data => {
      this.Provinces = data;
      console.log("thành công", data);
    }, error => {
      console.log("lỗi", error);
    });
  }
  getDistricts() {
    this.userService.getDistrict().subscribe(data => {
      this.Districts = data;
      console.log("thành công quan huyen", data);
    }, error => {
      console.log("lỗi", error);
    });
  }
  private getAllWards() {
    this.userService.getWard().subscribe(data => {
      this.Wards = data;
      console.log("thành công", data);
    }, error => {
      console.log("lỗi", error);
    });
  }
}

