export interface IMnfctrFee {
  id?: number;
  fctyId?: string | null;
  feeCd?: string | null;
  feeDt?: Date | null;
  fee?: number | null;
  curr?: string | null;
  lstMtnUsr?: string | null;
  lstMtnDt?: Date | null;
}

export class MnfctrFee implements IMnfctrFee {
  constructor(
    public id?: number,
    public fctyId?: string | null,
    public feeCd?: string | null,
    public feeDt?: Date | null,
    public fee?: number | null,
    public curr?: string | null,
    public lstMtnUsr?: string | null,
    public lstMtnDt?: Date | null
  ) {}
}
