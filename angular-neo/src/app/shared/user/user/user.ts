import {Province} from "../provinces/province";
import {District} from "../district/district";
import {Ward} from "../ward/ward";

export class User{
  id?: number;
  name?: string;
  email?: string;
  age?: number;
  address?: string;
  birthday?: string;
  province?: Province;
  district?: District;
  wards?:Ward;
}
