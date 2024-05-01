import { IDepartment } from './department';

export interface ICollege{
    collegeId:string;
    collegeName:string;
    address:string;
    location:string;
    city:string;
    contactNumber:string;
    departments: IDepartment[];
    
}