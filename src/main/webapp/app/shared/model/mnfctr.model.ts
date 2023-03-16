export interface IMnfctr {
  id?: number;
  uniNo?: string | null;
  mnfctrNmEn?: string | null;
  mnfctrNmCh?: string | null;
  contact?: string | null;
  eamil?: string | null;
  addr?: string | null;
  tel?: string | null;
  lstMtnUsr?: string | null;
  lstMtnDt?: Date | null;
}

export class Mnfctr implements IMnfctr {
  constructor(
    public id?: number,
    public uniNo?: string | null,
    public mnfctrNmEn?: string | null,
    public mnfctrNmCh?: string | null,
    public contact?: string | null,
    public eamil?: string | null,
    public addr?: string | null,
    public tel?: string | null,
    public lstMtnUsr?: string | null,
    public lstMtnDt?: Date | null
  ) {}
}
