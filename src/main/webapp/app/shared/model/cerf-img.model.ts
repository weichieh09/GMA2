export interface ICerfImg {
  id?: number;
  cerfTag?: string | null;
  imageFileContentType?: string | null;
  imageFile?: string | null;
  lstMtnUsr?: string | null;
  lstMtnDt?: Date | null;
}

export class CerfImg implements ICerfImg {
  constructor(
    public id?: number,
    public cerfTag?: string | null,
    public imageFileContentType?: string | null,
    public imageFile?: string | null,
    public lstMtnUsr?: string | null,
    public lstMtnDt?: Date | null
  ) {}
}
