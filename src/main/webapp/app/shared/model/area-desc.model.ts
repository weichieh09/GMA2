export interface IAreaDesc {
  id?: number;
  areaCd?: string | null;
  areaDesc?: string | null;
  lstMtnUsr?: string | null;
  lstMtnDt?: Date | null;
}

export class AreaDesc implements IAreaDesc {
  constructor(
    public id?: number,
    public areaCd?: string | null,
    public areaDesc?: string | null,
    public lstMtnUsr?: string | null,
    public lstMtnDt?: Date | null
  ) {}
}
