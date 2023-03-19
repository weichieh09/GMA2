export interface ICerfSearchView {
  id?: number;
  cerfNo?: string | null;
  cerfVer?: string | null;
  feeCd?: string | null;
  feeDesc?: string | null;
  fee?: number | null;
  areaCd?: string | null;
  areaDesc?: string | null;
  stsCd?: string | null;
  stsDesc?: string | null;
  applId?: string | null;
  mnfctrNmCh?: string | null;
  prodId?: string | null;
  mnfctrId?: string | null;
  fctyId?: string | null;
}

export class CerfSearchView implements ICerfSearchView {
  constructor(
    public id?: number,
    public cerfNo?: string | null,
    public cerfVer?: string | null,
    public feeCd?: string | null,
    public feeDesc?: string | null,
    public fee?: number | null,
    public areaCd?: string | null,
    public areaDesc?: string | null,
    public stsCd?: string | null,
    public stsDesc?: string | null,
    public applId?: string | null,
    public mnfctrNmCh?: string | null,
    public prodId?: string | null,
    public mnfctrId?: string | null,
    public fctyId?: string | null
  ) {}
}
