export interface ICerf2StdView {
  id?: number;
  cerfNo?: string | null;
  cerfVer?: string | null;
  stdNo?: string | null;
  stdVer?: string | null;
}

export class Cerf2StdView implements ICerf2StdView {
  constructor(
    public id?: number,
    public cerfNo?: string | null,
    public cerfVer?: string | null,
    public stdNo?: string | null,
    public stdVer?: string | null
  ) {}
}
