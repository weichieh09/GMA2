export interface IStd {
  id?: number;
  stdNo?: string | null;
  stdVer?: string | null;
  stsCd?: string | null;
  stdCd?: string | null;
  stdNm?: string | null;
  stdExpDt?: Date | null;
  remainDays?: number | null;
  lstMtnUsr?: string | null;
  lstMtnDt?: Date | null;
}

export class Std implements IStd {
  constructor(
    public id?: number,
    public stdNo?: string | null,
    public stdVer?: string | null,
    public stsCd?: string | null,
    public stdCd?: string | null,
    public stdNm?: string | null,
    public stdExpDt?: Date | null,
    public remainDays?: number | null,
    public lstMtnUsr?: string | null,
    public lstMtnDt?: Date | null
  ) {}
}
