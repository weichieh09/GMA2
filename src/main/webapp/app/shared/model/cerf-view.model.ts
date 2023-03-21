export interface ICerfView {
  id?: number;
  cerfNo?: string | null;
  cerfVer?: string | null;
  feeDt?: Date | null;
  feeDesc?: string | null;
  fee?: number | null;
  msg01?: string | null;
}

export class CerfView implements ICerfView {
  constructor(
    public id?: number,
    public cerfNo?: string | null,
    public cerfVer?: string | null,
    public feeDt?: Date | null,
    public feeDesc?: string | null,
    public fee?: number | null,
    public msg01?: string | null
  ) {}
}
