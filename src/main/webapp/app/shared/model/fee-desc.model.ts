export interface IFeeDesc {
  id?: number;
  feeCd?: string | null;
  feeDesc?: string | null;
  lstMtnUsr?: string | null;
  lstMtnDt?: Date | null;
}

export class FeeDesc implements IFeeDesc {
  constructor(
    public id?: number,
    public feeCd?: string | null,
    public feeDesc?: string | null,
    public lstMtnUsr?: string | null,
    public lstMtnDt?: Date | null
  ) {}
}
