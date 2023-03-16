export interface IProd2Fcty {
  id?: number;
  prodId?: string | null;
  mnfctrId?: string | null;
  fctyId?: string | null;
  inspectDt?: Date | null;
  discontinueFg?: string | null;
  discontinueDesc?: string | null;
  lstMtnUsr?: string | null;
  lstMtnDt?: Date | null;
}

export class Prod2Fcty implements IProd2Fcty {
  constructor(
    public id?: number,
    public prodId?: string | null,
    public mnfctrId?: string | null,
    public fctyId?: string | null,
    public inspectDt?: Date | null,
    public discontinueFg?: string | null,
    public discontinueDesc?: string | null,
    public lstMtnUsr?: string | null,
    public lstMtnDt?: Date | null
  ) {}
}
