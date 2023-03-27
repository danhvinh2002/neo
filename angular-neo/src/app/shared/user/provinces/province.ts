export class Province {
  name?: string;
  code?: any;
  division_type?: string;
  codename?: string;
  phone_code?: any;
  constructor(name?: string, code?: any, division_type?: string, codename?: string, phone_code?: any) {
    this.name = name;
    this.code = code;
    this.division_type = division_type;
    this.codename = codename;
    this.phone_code = phone_code;
  }

}
