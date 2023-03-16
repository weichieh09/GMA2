export interface IStsDesc {
  id?: number;
  stsCd?: string | null;
  stsDesc?: string | null;
  lstMtnUsr?: string | null;
  lstMtnDt?: Date | null;
}

export class StsDesc implements IStsDesc {
  constructor(
    public id?: number,
    public stsCd?: string | null,
    public stsDesc?: string | null,
    public lstMtnUsr?: string | null,
    public lstMtnDt?: Date | null
  ) {}
}
