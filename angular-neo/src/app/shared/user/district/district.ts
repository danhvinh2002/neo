export class District {
  id: number;
  name: string;
  provinceId: number;
  wards: any;
  constructor(id: number, name: string, provinceId: number, wards: any) {
    this.id = id;
    this.name = name;
    this.provinceId = provinceId;
    this.wards = wards;
  }
}
