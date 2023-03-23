export interface ICompany {
  id?: number;
  name?: string | null;
  tel?: string | null;
  addr?: string | null;
  email?: string | null;
}

export class Company implements ICompany {
  constructor(
    public id?: number,
    public name?: string | null,
    public tel?: string | null,
    public addr?: string | null,
    public email?: string | null
  ) {}
}
