export interface ICerf {
  id?: number;
  cerfNo?: string | null;
  cerfVer?: string | null;
  areaCd?: string | null;
  stsCd?: string | null;
  applId?: string | null;
  cerfTag?: string | null;
  issuDt?: Date | null;
  cerfExpDt?: Date | null;
  remainDays?: number | null;
  upldFileContentType?: string | null;
  upldFile?: string | null;
  lstMtnUsr?: string | null;
  lstMtnDt?: Date | null;
}

export class Cerf implements ICerf {
  constructor(
    public id?: number,
    public cerfNo?: string | null,
    public cerfVer?: string | null,
    public areaCd?: string | null,
    public stsCd?: string | null,
    public applId?: string | null,
    public cerfTag?: string | null,
    public issuDt?: Date | null,
    public cerfExpDt?: Date | null,
    public remainDays?: number | null,
    public upldFileContentType?: string | null,
    public upldFile?: string | null,
    public lstMtnUsr?: string | null,
    public lstMtnDt?: Date | null
  ) {}
}
