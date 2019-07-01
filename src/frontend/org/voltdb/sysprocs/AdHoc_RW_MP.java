/* This file is part of VoltDB.
 * Copyright (C) 2008-2019 VoltDB Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with VoltDB.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.voltdb.sysprocs;

import org.voltdb.SystemProcedureExecutionContext;
import org.voltdb.VoltTable;

/**
 * Execute a user-provided read-write multi-partition SQL statement.
 * This code coordinates the execution of the plan fragments generated by the
 * embedded planner process.
 *
 * AdHocBase implements the core logic.
 */
public class AdHoc_RW_MP extends AdHocBase {

    /**
     * System procedure run hook.
     * Use the base class implementation.
     *
     * @param ctx execution context
     * @param serializedBatchData serialized batch data
     *
     * @return  results as VoltTable array
     */
    public VoltTable[] run(SystemProcedureExecutionContext ctx, byte[] serializedBatchData) {
        return runAdHoc(ctx, serializedBatchData);
    }

    @Override
    public boolean shouldProcForReplay() {
        return true;
    }
}
