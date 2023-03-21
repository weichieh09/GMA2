export interface ICerf2MnfctrView {
  id?: number;
  cerfNo?: string | null;
  cerfVer?: string | null;
  area?: string | null;
  sts?: string | null;
  issuDt?: Date | null;
  remainDays?: number | null;
  applId?: string | null;
  mnfctrNmCh?: string | null;
  upldFileContentType?: string | null;
  upldFile?: string | null;
  imageFileContentType?: string | null;
  imageFile?: string | null;
  lstMtnUsr?: string | null;
  lstMtnDt?: Date | null;
}

export class Cerf2MnfctrView implements ICerf2MnfctrView {
  constructor(
    public id?: number,
    public cerfNo?: string | null,
    public cerfVer?: string | null,
    public area?: string | null,
    public sts?: string | null,
    public issuDt?: Date | null,
    public remainDays?: number | null,
    public applId?: string | null,
    public mnfctrNmCh?: string | null,
    public upldFileContentType?: string | null,
    public upldFile?: string | null,
    public imageFileContentType?: string | null,
    public imageFile?: string | null,
    public lstMtnUsr?: string | null,
    public lstMtnDt?: Date | null
  ) {}
}
