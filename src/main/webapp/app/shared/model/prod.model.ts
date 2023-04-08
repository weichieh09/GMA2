import { IProdCountry } from '@/shared/model/prod-country.model';
import { IProdStd } from '@/shared/model/prod-std.model';
import { ICerfProd } from '@/shared/model/cerf-prod.model';
import { IFeeProdCerfCompany } from '@/shared/model/fee-prod-cerf-company.model';
import { IProdSticker } from '@/shared/model/prod-sticker.model';

export interface IProd {
  id?: number;
  prodNo?: string | null;
  enName?: string | null;
  chName?: string | null;
  hsCode?: string | null;
  cccCode?: string | null;
  prodCountries?: IProdCountry[] | null;
  prodStds?: IProdStd[] | null;
  cerfProds?: ICerfProd[] | null;
  feeProdCerfCompanies?: IFeeProdCerfCompany[] | null;
  prodStickers?: IProdSticker[] | null;
  prodStickerList?: [] | null;
}

export class Prod implements IProd {
  constructor(
    public id?: number,
    public prodNo?: string | null,
    public enName?: string | null,
    public chName?: string | null,
    public hsCode?: string | null,
    public cccCode?: string | null,
    public prodCountries?: IProdCountry[] | null,
    public prodStds?: IProdStd[] | null,
    public cerfProds?: ICerfProd[] | null,
    public feeProdCerfCompanies?: IFeeProdCerfCompany[] | null,
    public prodStickers?: IProdSticker[] | null,
    public prodStickerList?: [] | null
  ) {}
}
